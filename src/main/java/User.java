import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String email;
    private String password;
    private String name;

    public User getExistedUser() {
        return new User("denissangi@yandex.ru", "Qwer1234", "Denis Sangi");
    }

    public User getRandomUser() {
        return new User(RandomStringUtils.randomAlphanumeric(6) + "@yandex.ru", RandomStringUtils.randomAlphanumeric(8), RandomStringUtils.randomAlphanumeric(6));
    }

    public User getUserWithoutName() {
        return new User(RandomStringUtils.randomAlphanumeric(6) + "yandex.ru", RandomStringUtils.randomAlphanumeric(8), null);
    }

    public User getIncorrectLoginUser() {
        return new User("denissangiincorrect@yandex.ru", "Qwer1234", "Denis Sangi");
    }

    public User getIncorrectPasswordUser() {
        return new User("denissangi@yandex.ru", "incorrectPassw0rd", "Denis Sangi");
    }
}
