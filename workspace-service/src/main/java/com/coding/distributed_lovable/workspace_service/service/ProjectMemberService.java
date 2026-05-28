package com.coding.distributed_lovable.workspace_service.service;

import com.coding.distributed_lovable.workspace_service.dto.Member.InviteMemberRequest;
import com.coding.distributed_lovable.workspace_service.dto.Member.MemberResponse;
import com.coding.distributed_lovable.workspace_service.dto.Member.UpdateMemberRequest;

import java.util.List;

public interface ProjectMemberService {
      List<MemberResponse> getProjectMembers(Long projectId);

     MemberResponse inviteMember(Long projectId, InviteMemberRequest request);

     MemberResponse updateMemberRole(Long projectId, long memberId, UpdateMemberRequest request);

    void  removeProjectMember(Long projectId, long memberId);
}
