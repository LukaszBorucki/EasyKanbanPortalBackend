package co.borucki.EasyKanbanPortalBackend.user.controller;

import co.borucki.EasyKanbanPortalBackend.user.dto.CreateUserDto;
import co.borucki.EasyKanbanPortalBackend.user.dto.UserDto;
import co.borucki.EasyKanbanPortalBackend.user.factory.UserFactory;
import co.borucki.EasyKanbanPortalBackend.user.model.UserModel;
import co.borucki.EasyKanbanPortalBackend.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.Model;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;
    private final UserFactory factory;

    @Qualifier("orikaMapper")
    @Autowired
    private MapperFacade mapper;

    @Autowired
    public UserController(UserService service, UserFactory factory) {
        this.service = service;
        this.factory = factory;
    }

    @ApiOperation(value = "Create new User")
    @PostMapping(value = "/")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDto userDto) {

        return ResponseEntity.
                ok(mapper.map(service.create(factory.fromDto(userDto)), UserDto.class));
    }

    @ApiOperation(value = "Get all users")
    @GetMapping(value = "/")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(mapper.mapAsList(service.getAll(), UserDto.class));
    }

    @ApiOperation(value = "Get user by id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUserById(@ApiParam(value = "id", required = true) @PathVariable(value = "id") String id ){
        return ResponseEntity.ok(mapper.map(service.getById(id).get(), UserDto.class));
    }
}
