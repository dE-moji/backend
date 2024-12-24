package dEmoji.dEmoji.domain.PoCData.service;

import dEmoji.dEmoji.domain.PoCData.dto.MoveCheckDTO;
import dEmoji.dEmoji.domain.PoCData.entity.MoveCheck;
import dEmoji.dEmoji.domain.PoCData.entity.PoCUser;
import dEmoji.dEmoji.domain.PoCData.repository.MoveCheckRepository;
import dEmoji.dEmoji.domain.PoCData.repository.PoCUserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MoveCheckService {

    private final MoveCheckRepository moveCheckRepository;
    private final PoCUserRepository pocUserRepository;

    public PoCUser findUser(long userId){
        PoCUser poCUser = pocUserRepository.findPoCUserByPocId(userId)
                .orElse(null);

        return poCUser;
    }

    public boolean updateMove(MoveCheckDTO moveCheckDTO){

        PoCUser poCUser = findUser(moveCheckDTO.getUserId());

        if(poCUser == null) return false;

        MoveCheck moveCheck = moveCheckRepository.findByPocUserPocId(moveCheckDTO.getUserId())
                .orElseGet(() -> {
                    MoveCheck newMoveCheck = new MoveCheck();
                    newMoveCheck.setPocUser(poCUser);
                    return moveCheckRepository.save(newMoveCheck);
                });

        switch (moveCheckDTO.getPageNum()) {
            case 1:
                moveCheck.setPage1(moveCheck.getPage1() + 1);
                break;
            case 2:
                moveCheck.setPage2(moveCheck.getPage2() + 1);
                break;
            case 3:
                moveCheck.setPage3(moveCheck.getPage3() + 1);
                break;
            case 4:
                moveCheck.setPage4(moveCheck.getPage4() + 1);
                break;
            case 5:
                moveCheck.setPage5(moveCheck.getPage5() + 1);
                break;
            case 6:
                moveCheck.setPage6(moveCheck.getPage6() + 1);
                break;
            default:
                return false;
        }
        moveCheckRepository.save(moveCheck);
        return true;
    }
}


