package dev.omedia.service;

import dev.omedia.domain.User;
import dev.omedia.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {
    @SpyBean
    private UserService service;
    @Autowired
    private UserRepository repository;

    @BeforeEach
    public void setUp(){
        repository.deleteAll();
        repository.resetId();
    }

    @Test
    void createUser() {
        //Given
        User user = new User("1", "01", "badri","shubladze");
        //When
        service.createUser(user);
        //Then
        //TODO: Check if event was sent
        //TODO: Check event validity
        Optional<User> userById = repository.findByUuid("1");
        org.junit.jupiter.api.Assertions.assertTrue(userById.isPresent());
        Assertions.assertThat(user).isEqualTo(userById.get());
    }

    @Test
    void getUser() {
        //Given
        User user = new User("1", "01", "badri","shubladze");
        repository.save(user);
        //When
        User actualUser = service.getUser(user.getUuid());
        //Then
        Assertions.assertThat(user).isEqualTo(actualUser);
    }

    @Test
    void getAllUsers() {
        //Given
        User mock1 = new User("1", "01", "badri","shubladze");
        User mock2 = new User("2", "02", "grisha","oniani");
        List<User> mockList = List.of(mock1, mock2);
        repository.saveAll(mockList);
        //When
        Iterable<User> allUsers = service.getAllUsers();
        List<User> result = StreamSupport.stream(allUsers.spliterator(), false)
                .collect(Collectors.toList());
        //Then
        Assertions.assertThat(2).isEqualTo(result.size());
        Assertions.assertThat(mockList).isEqualTo(result);
    }

    @Test
    void update() {
        //Given
        User mock = new User("1", "01", "badri","shubladze");
//        Mockito.when(service.getUser(Mockito.anyString()())).thenReturn(mock);
        Mockito.doReturn(mock).when(service).getUser(Mockito.anyString());
        //When
        User updatedMock = new User("1", "01", "badri","shubladze");
        User updated = service.update(updatedMock.getUuid(), updatedMock);
        //Then
        Assertions.assertThat(updatedMock).isEqualTo(updated);
    }

    @Test
    void updateThrowsException(){
        //Given
        Mockito.doThrow(IllegalArgumentException.class).when(service).getUser(Mockito.anyString());
        //
        User updatedMock = new User("1", "01", "badri","shubladze");
        Assertions.assertThatThrownBy(()->service.update(updatedMock.getUuid(), updatedMock))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getUserThrowException(){
        Assertions.assertThatThrownBy(()->service.getUser("2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}