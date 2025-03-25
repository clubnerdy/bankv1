package com.metacoding.bankv1.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//@Service
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

    // 로그인만 예외로 @Post (조회시에도) 주소창에 비번같은거 노출되면 안되니까 바디로 보내야지
    @PostMapping("/login")
    public String login(UserRequest.LoginDTO loginDTO) {
    User sessionUser = userService.로그인(loginDTO);
    session.setAttribute("sessionUser", sessionUser); // stateful
        return "redirect:/";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        return "user/login-form";
    }

    @GetMapping("/join-form")
    public String joinForm() {
        return "user/join-form";
    }

    @PostMapping("/join")
    public String join(UserRequest.JoinDTO joinDTO) {

        // 유효성 검사
//        if(joinDTO.getUsername().length() > 12) {
//            throw new RuntimeException("username too long");
//        }

        userService.회원가입(joinDTO);
        return "redirect:/login-form";
    }

}
