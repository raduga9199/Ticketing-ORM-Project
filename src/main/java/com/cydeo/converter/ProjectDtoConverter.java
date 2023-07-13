package com.cydeo.converter;

import com.cydeo.dto.ProjectDTO;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class ProjectDtoConverter implements Converter<String, ProjectDTO> {
    @Override
    public ProjectDTO convert(String source) {
        return null;
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super ProjectDTO, ? extends U> after) {
        return Converter.super.andThen(after);
    }


//    ProjectService projectService;

    //injection
//    public ProjectDtoConverter(ProjectService projectService) {
//        this.projectService = projectService;
//    }
//
//    @Override
//    public ProjectDTO convert(String source) {
//
//        if (source == null || source.equals("")) {
//            return null;
//        }
//
//        return projectService.findById(source);
//
//    }

}
