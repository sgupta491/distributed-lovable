package com.coding.distributed_lovable.workspace_service.controller;

import com.coding.distributed_lovable.workspace_service.dto.Member.InviteMemberRequest;
import com.coding.distributed_lovable.workspace_service.dto.Member.MemberResponse;
import com.coding.distributed_lovable.workspace_service.dto.Member.UpdateMemberRequest;
import com.coding.distributed_lovable.workspace_service.service.ProjectMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;


    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable Long projectId){
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(@PathVariable Long projectId, @RequestBody @Valid InviteMemberRequest request){
    return ResponseEntity.status(HttpStatus.CREATED).body(
            projectMemberService.inviteMember(projectId, request)
            );
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(
            @PathVariable Long projectId,
            @PathVariable long memberId,
            @RequestBody @Valid UpdateMemberRequest request
    ){
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId, memberId, request));
    }


    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> removeMember(
            @PathVariable Long projectId,
            @PathVariable long memberId
    ){
        projectMemberService.removeProjectMember(projectId, memberId);
        return ResponseEntity.noContent().build();
    }


}
