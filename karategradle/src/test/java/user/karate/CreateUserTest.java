package user.karate;


import com.intuit.karate.junit5.Karate;

public class CreateUserTest {

    @Karate.Test
    Karate testCreateUser() {
        return Karate.run("classpath:features/createUser.feature").tags("@createUser");
    }

    @Karate.Test
    Karate testCreateUserJson() { return Karate.run("classpath:features/createUser.feature").tags("@createUserJson"); }
}
