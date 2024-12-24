package dEmoji.dEmoji.domain.PoCData.controller;

import dEmoji.dEmoji.domain.PoCData.dto.PoCUserDTO;
import dEmoji.dEmoji.domain.PoCData.dto.PoCUserRequest;
import dEmoji.dEmoji.domain.PoCData.service.PoCUserService;
import dEmoji.dEmoji.global.exception.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PoCUserController {
    private final PoCUserService poCUserService;

    @GetMapping("/user/info")
    public BaseResponse getUserInfo(@RequestParam long userId) {

        PoCUserDTO poCUserDTO = poCUserService.getUserData(new PoCUserRequest(userId));

       if ( poCUserDTO == null) {
           return BaseResponse.builder()
                   .data(null)
                   .code(500)
                   .isSuccess(false)
                   .message("해당 페이지에 대한 정보를 가져오는데 실패하였습니다.")
                   .build();
         }

        return BaseResponse.builder()
                .data(poCUserDTO)
                .code(200)
                .isSuccess(true)
                .message("해당 페이지에 대한 정보를 가져오는데 성공했습니다.")
                .build();
    }

    @PostMapping("/user/makeUser")
    public BaseResponse makeUser(@RequestBody PoCUserDTO poCUserDTO) {
        poCUserService.saveUserData(poCUserDTO);
        return BaseResponse.builder()
                .code(200)
                .isSuccess(true)
                .message("새로운 페이지 생성에 성공하였습니다.")
                .build();
    }
}
