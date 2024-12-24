package dEmoji.dEmoji.domain.PoCData.controller;

import dEmoji.dEmoji.domain.PoCData.dto.MoveCheckDTO;
import dEmoji.dEmoji.domain.PoCData.service.MoveCheckService;
import dEmoji.dEmoji.global.exception.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MoveCheckController {
    private final MoveCheckService moveCheckService;


    @PostMapping("/page/update")
    public BaseResponse updatePageMove(@RequestBody MoveCheckDTO moveCheckDTO){
        if(moveCheckService.updateMove(moveCheckDTO)){
            return BaseResponse.builder()
                    .code(200)
                    .isSuccess(true)
                    .message("페이지에 대한 값의 갱신에 성공하였습니다.")
                    .build();
        }
        return BaseResponse.builder()
                .code(500)
                .isSuccess(false)
                .message("페이지 값 갱신에 실패하였습니다.")
                .build();
    }
}
