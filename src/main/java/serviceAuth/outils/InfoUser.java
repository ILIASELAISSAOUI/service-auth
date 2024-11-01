package serviceAuth.outils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class InfoUser {
    private String username;
    private String password;
}
