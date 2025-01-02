package com.study.demo.controller;


import com.study.demo.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "MemberController", description = "Member API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @Operation(summary = "사용자 이름으로 멤버 조회", description = "사용자 이름 userName과 일치하는 Member 조회 API")
    @GetMapping()
    public ResponseEntity<?> getMemberByUserName(@RequestParam(name="userName") String userName){
        try {
            return ResponseEntity.ok(memberService.findMemberByUserName(userName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @Operation(summary = "닉네임 변경", description = "사용자 닉네임을 변경하는 API")
    @PatchMapping()
    public ResponseEntity<?> patchMemberByNickName(@RequestParam(name="memberId") Long memberId, @RequestParam(name="nickName") String nickName){
        try {
            return ResponseEntity.ok(memberService.updateMemberNickName(memberId, nickName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @Operation(summary = "모든 멤버 조회", description = "db에 저장되어 있는 모든 Member 조회 API")
    @GetMapping("/all")
    public ResponseEntity<?> getAllMembers(){
        try {
            return ResponseEntity.ok(memberService.findAllMembers());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}