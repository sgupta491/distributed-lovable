package com.coding.distributed_lovable.workspace_service.controller;

import com.coding.distributed_lovable.common_lib.dto.FileTreeDto;
import com.coding.distributed_lovable.workspace_service.dto.project.FileContentResponse;
import com.coding.distributed_lovable.workspace_service.service.ProjectFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects/{projectId}/files")
public class FileController {

    private final ProjectFileService projectFileService;

    public FileController(ProjectFileService projectFileService) {
        this.projectFileService = projectFileService;
    }

    @GetMapping
    public ResponseEntity<FileTreeDto> getFileTree(@PathVariable Long projectId){
        Long userId = 1L;
        return ResponseEntity.ok(projectFileService.getFileTree(projectId));
    }

    @GetMapping("/content")
    public ResponseEntity<String> getFile(
            @PathVariable Long projectId,
            @RequestParam String path) {
        return ResponseEntity.ok(projectFileService.getFileContent(projectId, path));
    }

}
