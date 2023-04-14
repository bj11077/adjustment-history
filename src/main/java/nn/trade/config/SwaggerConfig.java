package nn.trade.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "정산", version = "0.1",
        description = "우측 Authorize로 토큰전역사용가능, 설명따로 없는건 공통 CRUD RestAPI",
        contact = @Contact(name = "Name")),
        security = {@SecurityRequirement(name = "bearerToken")}
)
@SecuritySchemes({
@SecurityScheme(name = "bearerToken", type = SecuritySchemeType.HTTP,
        scheme = "bearer", bearerFormat = "JWT")
})
public class SwaggerConfig {
}
