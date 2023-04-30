package ntou.soselab.msdobot_llm_lab.Service;

import jakarta.annotation.PostConstruct;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class JDAService {
    private final JDA jda;

    @Autowired
    public JDAService(Environment env, DiscordMessageListener listener) {
        String appToken = env.getProperty("discord.application.token");
        this.jda = JDABuilder
                .createDefault(appToken)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
        jda.addEventListener(listener);
    }
}