package c07;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class C07_8 {

    @Test
    public void lang() {
        System.out.printf("%s%s%n", "1", "2");
    }

    //    @Test
    public void math() {
        BigInteger bigInteger = new BigInteger("1234");
        System.out.println(bigInteger);

        BigDecimal bigDecimal = new BigDecimal("12.34");
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.compareTo(new BigDecimal("0")));
    }

    //    @Test
    public void text() {
        System.out.println(new DecimalFormat("###,###0.00").format(0.11));
    }

    //    @Test
    @SneakyThrows
    public void util() {
        File file = new File("C:/Users/Administrator/Desktop/test.jpg");
        byte[] inputs = new byte[Math.toIntExact(file.length())];
        new FileInputStream(file).read(inputs);
        String str = Base64.getEncoder().encodeToString(inputs);
        System.out.println(str);

        OutputStream outputStream = Files.newOutputStream(Paths.get("C:/Users/Administrator/Desktop/test2.jpg"));
        outputStream.write(Base64.getDecoder().decode(str));
        outputStream.flush();
    }

    public static void util2() {
        List<String> input = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入列表，换行后按Ctrl+D结束：");
            while (true) {
                String line = scanner.nextLine();
                input.add(line);
            }
        } catch (NoSuchElementException e) {
            input.removeIf(element -> "".equals(element) || "\n".equals(element));
            List<String> output = input.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
            output.forEach(System.out::println);
        }
    }

    class CustomTimerTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("CustomTimerTask");
        }
    }

    //    @Test
    public void util3() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        Date date = calendar.getTime();
    }

    //    @Test
    public void util4() {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }

}
