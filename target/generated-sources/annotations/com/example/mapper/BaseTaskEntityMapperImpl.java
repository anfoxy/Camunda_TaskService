package com.example.mapper;

import com.example.dto.BaseTaskDto;
import com.example.dto.TaskUserDto;
import com.example.dto.UserDto;
import com.example.entity.BaseTaskEntity;
import com.example.entity.TaskUserEntity;
import com.example.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-07T14:27:35+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class BaseTaskEntityMapperImpl implements BaseTaskEntityMapper {

    @Override
    public BaseTaskEntity toEntity(BaseTaskDto taskDTO) {
        if ( taskDTO == null ) {
            return null;
        }

        BaseTaskEntity.BaseTaskEntityBuilder baseTaskEntity = BaseTaskEntity.builder();

        baseTaskEntity.id( taskDTO.getId() );
        baseTaskEntity.task( taskUserDtoToTaskUserEntity( taskDTO.getTask() ) );
        baseTaskEntity.userId( userDtoToUserEntity( taskDTO.getUserId() ) );
        baseTaskEntity.username( taskDTO.getUsername() );
        baseTaskEntity.status( taskDTO.getStatus() );
        baseTaskEntity.time( taskDTO.getTime() );
        baseTaskEntity.email( taskDTO.getEmail() );

        return baseTaskEntity.build();
    }

    @Override
    public BaseTaskDto toDTO(BaseTaskEntity taskEntity) {
        if ( taskEntity == null ) {
            return null;
        }

        BaseTaskDto baseTaskDto = new BaseTaskDto();

        baseTaskDto.setId( taskEntity.getId() );
        baseTaskDto.setTask( taskUserEntityToTaskUserDto( taskEntity.getTask() ) );
        baseTaskDto.setUserId( userEntityToUserDto( taskEntity.getUserId() ) );
        baseTaskDto.setUsername( taskEntity.getUsername() );
        baseTaskDto.setStatus( taskEntity.getStatus() );
        baseTaskDto.setTime( taskEntity.getTime() );
        baseTaskDto.setEmail( taskEntity.getEmail() );

        return baseTaskDto;
    }

    protected List<TaskUserEntity> taskUserDtoListToTaskUserEntityList(List<TaskUserDto> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskUserEntity> list1 = new ArrayList<TaskUserEntity>( list.size() );
        for ( TaskUserDto taskUserDto : list ) {
            list1.add( taskUserDtoToTaskUserEntity( taskUserDto ) );
        }

        return list1;
    }

    protected TaskUserEntity taskUserDtoToTaskUserEntity(TaskUserDto taskUserDto) {
        if ( taskUserDto == null ) {
            return null;
        }

        TaskUserEntity.TaskUserEntityBuilder taskUserEntity = TaskUserEntity.builder();

        taskUserEntity.id_task( taskUserDto.getId_task() );
        taskUserEntity.baseTask( toEntity( taskUserDto.getBaseTask() ) );
        taskUserEntity.parent( taskUserDtoToTaskUserEntity( taskUserDto.getParent() ) );
        taskUserEntity.tasks( taskUserDtoListToTaskUserEntityList( taskUserDto.getTasks() ) );
        taskUserEntity.description( taskUserDto.getDescription() );
        taskUserEntity.name( taskUserDto.getName() );
        taskUserEntity.status( taskUserDto.getStatus() );
        taskUserEntity.type( taskUserDto.getType() );

        return taskUserEntity.build();
    }

    protected UserEntity userDtoToUserEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        return userEntity;
    }

    protected List<TaskUserDto> taskUserEntityListToTaskUserDtoList(List<TaskUserEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskUserDto> list1 = new ArrayList<TaskUserDto>( list.size() );
        for ( TaskUserEntity taskUserEntity : list ) {
            list1.add( taskUserEntityToTaskUserDto( taskUserEntity ) );
        }

        return list1;
    }

    protected TaskUserDto taskUserEntityToTaskUserDto(TaskUserEntity taskUserEntity) {
        if ( taskUserEntity == null ) {
            return null;
        }

        TaskUserDto taskUserDto = new TaskUserDto();

        taskUserDto.setId_task( taskUserEntity.getId_task() );
        taskUserDto.setBaseTask( toDTO( taskUserEntity.getBaseTask() ) );
        taskUserDto.setParent( taskUserEntityToTaskUserDto( taskUserEntity.getParent() ) );
        taskUserDto.setTasks( taskUserEntityListToTaskUserDtoList( taskUserEntity.getTasks() ) );
        taskUserDto.setDescription( taskUserEntity.getDescription() );
        taskUserDto.setName( taskUserEntity.getName() );
        taskUserDto.setStatus( taskUserEntity.getStatus() );
        taskUserDto.setType( taskUserEntity.getType() );

        return taskUserDto;
    }

    protected UserDto userEntityToUserDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        String username = null;

        username = userEntity.getUsername();

        UserDto userDto = new UserDto( username );

        return userDto;
    }
}
