package Controller;
import Model.Record.UserModel;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.catalina.User;
import Exception.UserNotFound;

@RestController
@RequestMapping("/api/users")
public class UserController{
        // Autowired annotation is used for automatic injection of UserRepository dependency.
        // This is a constructor-based dependency injection.
    private final UserRepository userRepository;
@Autowired
    public UserController (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //  retrieve a list of all users
    @GetMapping("/List-Users")
    public ResponseEntity ListUsers(){
        Iterable<UserModel> user = userRepository.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(user);
}
    //  retrieve a user by ID
    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound ("Perfil de usuário não encontrado com o ID: " + id));
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    // create a new user
    @PostMapping
    public ResponseEntity createUser(@RequestBody UserModel user) {

        UserModel savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    // update an existing user by ID
    @PutMapping("/{id}")
    public ResponseEntity UserupdateUser(@PathVariable Long id, @RequestBody User user) {
        if (!id.equals(getUserById(id))) {
            return ResponseEntity.badRequest().build();
    }
        // Save the updated user to the repository
        UserModel savedUser = userRepository.save((UserModel) user);
        userRepository.updateUserId(id, user.getUserDatabase());

        return ResponseEntity.status(HttpStatus.OK).body(savedUser);
    }

    // update an existing user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
