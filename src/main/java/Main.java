import com.domain.classes.EngagesFactory;
import com.domain.intefaces.IEngager;
import com.domain.intefaces.IMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Map<String, String>> messages = new ArrayList<>() {{
            add(new HashMap<>() {{
                put("type", "SENDGRID");
                put("message", "this is a message # 1 of SENDGRID");
            }});

            add(new HashMap<>() {{
                put("type", "KLAVIYO");
                put("message", "this is a message # 1 of KLAVIYO");
            }});

            add(new HashMap<>() {{
                put("type", "MANDRILL");
                put("message", "this is a message # 1 of MANDRILL");
            }});

            add(new HashMap<>() {{
                put("type", "SENDGRID");
                put("message", "this is a message # 2 of KLAVIYO");
            }});

            add(new HashMap<>() {{
                put("type", "KLAVIYO");
                put("message", "this is a message # 2 of KLAVIYO");
            }});
        }};

        for (var message: messages) {
            IEngager engage = EngagesFactory.get(message);
            if (engage != null) {
                IMessage msg = engage.BuildMessage(message);
                engage.SendMessage(msg);
            }
            else {
                System.out.println("Can't find handler for '" + message.get("type") + "' engage");
            }
        }
    }
}