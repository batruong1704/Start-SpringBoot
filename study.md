## 1. Spring

### 1.1. Dependency Injection
- Nhằm giảm bớt sự phụ thộc liên kết giữa các lớp với nhau nhằm tăng sự hoạt động giữa các lớp và không biết gì về cấu trúc hoặc chi tiết tiết triển khai giữa các lớp khác.
- Trong DI, các sự phụ thuộc của một đối tượng không được tạo bên trong đối tượng đó mà được cung cấp từ bên ngoài.
- DI thường thực hiện thông qua 3 cách:
	- Constructor Injection
	- Setter Injection
	- Interface Injection

### 1.2. Annototaion 
cho phép thêm các thông tin bổ sung vào mã nguồn của bạn, giúp trình biên dịch và các công cụ phát triển hiểu và xử lý mã nguồn của bạn một cách thuông minh.
- `@Component`: đánh dấu trên các class để cho biết chúng là các bean được quản lý bởi SpỉngBoot. ĐIều này có nghĩa là Spring Boot sẽ tạo và quản lý các instance của các instance của các class được đánh dáu @Component.
- `@Autowired`: sử dụng để tiêm các dependency vò các thành phần khác nhau. khi đánh dấu một thuộc tính tằng @Autowired, Spring Boot sẽ tiêm một instance của dependency tương ứng vào thuộc tính đó. (thay thế Container Injection)

### 1.3. IoC (Inversion of Control)
- Nguyên tắc lập trình IoC, luồng điều khiển trong ứng dụng không được quyết định bởi ứng dụng mà quết định bởi framework hoặc container bên ngoài. 
- IoC thường đi kèm với DI, nên các dependency được quản lý và cung cấp bởi 1 framework hoặc container. Framework sẽ quản lý việc tạo và quản lý các đối tượng và phụ thuộc.

Ví dụ ứng dụng gồm 4 lớp:
- Main
- Email Service
- Message Service
- Client

Bằng cách đánh dấu `@Component` lên `Email Service` và `Client` thì ApplicationContext (Spring IoC Container) sẽ quản lý các đối tượng này và gọi lại nó bằng *context.getBean*
Bằng `MessageService`, ta đã thực hiện DI nhằm giảm tải sự phụ thuộc lớp *sendMessage* của `emailService` lên `Client`

Tuy nhiên, nếu nâng độ khó lên bằng cách thêm SMS Service. Việc Injection không nắm được đâu là lớp cần được lấy.
Khi này, ta có nhiều cách để xác định lớp cần lấy:
- `@Primary`: đánh dấu lên 1 bean để xác định đây là bean mặc định nếu có nhiều bean cùng loại. (Lên đầu emailService hoặc smsService)
- Inject tất cả các implement của 1 interface vào 1 list và lấy ra bằng `@Autowired List<MessageService> messageServices`
```java
@Component
public class Client {
    private final List<MessageService> messageServices;
    
    @Autowired
    public Client(List<MessageService> messageServices) {
        this.messageServices = messageServices;
    }
}
```

- `@Qualifier`: xác định bean cần lấy bằng tên hoặc tên bean
```java
@Component
public class Client {
    @Autowired
    @Qualifier("emailService")
    private MessageService messageService;

    public Client(@Qualifier("emailService") EmailService emailService) {
        this.messageService = emailService;
    }

    public void processMessage(String message) {
        this.messageService.sendMessage(message);
    }
}
```

### 1.4. Bean
- Bean là một Object mà Spring IoC Container quản lý. Bean được tạo, cấu hình và quản lý bởi Spring IoC Container.
- Có 2 cách tạo `Bean`:
  - Cách 1: Dùng `@Component` để đánh dấu trên class để cho biết chúng là các bean được quản lý bởi Spring Boot. Tương tự có thể dùng với @Service, @Repository, @Controller
  - Cách 2: Dùng `@Bean` trong class `@Configuration` để tạo Bean.
    - `@Configuration`: đánh dấu trên class để cho biết class này chứa các Bean.
    - Spring Boot sẽ tự map các class được đánh dấu annotation `@Configuration` để tạo và quản lý các `Bean`.














