package com.coding.distributed_lovable.intelligence_service.llm;

import com.coding.distributed_lovable.intelligence_service.client.WorkspaceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CodeGenerationTools {

    private final Long projectId;
    private final WorkspaceClient workspaceClient;

    @Tool(name = "read_files",
    description = "Read the content of the files. Only input the file in present inside the FILE_TREE. DO NOT input any path which are not under the FILE_TREE.")
    public List<String> readFiles(

            @ToolParam(description = "List of relative paths (e.g., ['src/App.tsx'])")
            List<String> paths){

        List<String> result = new ArrayList<>();

        for(String path: paths){
            String cleanPath = path.startsWith("/") ? path.substring(1): path;

            String content = workspaceClient.getFileContent(projectId, cleanPath);

            result.add(String.format(
                    "--- START OF FILE: %s ---\n%s\n--- END OF FILE ---",
                    cleanPath, content
                    ));
        }

        return result;
    }

}
