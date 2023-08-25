package com.gl.mongodb.controllers;

import com.gl.mongodb.model.ReactionEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Enum")
public class ReactionEnumController {
    @GetMapping
    public ResponseEntity<List<String>> getReactionEnumValues() {
        List<String> enumValues = Arrays.stream(ReactionEnum.values())
                .map(ReactionEnum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(enumValues);
    }

    @GetMapping("/{enumName}")
    public ResponseEntity<String> getReactionEnumValue(@PathVariable String enumName) {
        try {
            ReactionEnum enumValue = ReactionEnum.valueOf(enumName);
            return ResponseEntity.ok(enumValue.getDisplayName());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
