package me.choi.inflearnthejavatest.study;

import me.choi.inflearnthejavatest.domain.Member;
import me.choi.inflearnthejavatest.domain.Study;
import me.choi.inflearnthejavatest.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class StudyServiceTest {

    @Mock MemberService memberService;
    @Autowired
    StudyRepository studyRepository;

    @Test
    void createStudyService() {
        //Given
        StudyService studyService = new StudyService(memberService,studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("rownsdn912@gmail.com");

        Study study = new Study(10,"test");

//        when(memberService.findById(1L)).thenReturn(Optional.of(member));
//        when(studyRepository.save(study)).thenReturn(study);

        given(memberService.findById(1L)).willReturn(Optional.of(member));
        given(studyRepository.save(study)).willReturn(study);


        //When
        studyService.createNewStudy(1L, study);

        //Then
        assertEquals(member, study.getOwner());
//        verify(memberService, times(1)).notify(study);
//        verify(memberService, never()).validate(any());

        then(memberService).should(times(1)).notify(study);


//        verifyNoMoreInteractions(memberService);
        then(memberService).shouldHaveNoMoreInteractions();
    }

}