package com.coding.distributed_lovable.workspace_service.mapper;

import com.coding.distributed_lovable.workspace_service.dto.Member.MemberResponse;
import com.coding.distributed_lovable.workspace_service.entity.ProjectMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target = "userId", source = "id.userId")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
