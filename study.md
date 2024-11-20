## 1. Spring

### 1.1. Dependency Injection
- Nhằm giảm bớt sự phụ thộc liên kết giữa các lớp với nhau nhằm tăng sự hoạt động giữa các lớp và không biết gì về cấu trúc hoặc chi tiết tiết triển khai giữa các lớp khác.
- Trong DI, các sự phụ thuộc của một đối tượng không được tạo bên trong đối tượng đó mà được cung cấp từ bên ngoài.
- DI thường thực hiện thông qua 3 cách chỉnh"
	- Constructor Injection
	- Setter Injection
	- Interface Injection

### 1.2. Annototaion 
cho phép thêm các thông tin bổ sung vào mã nguồn của bạn, giúp trình biên dịch và các công cụ phát triển hiểu và xử lý mã nguồn của bạn một cách thuông minh.
- `@Component`: đánh dấu trên các class để cho biết chúng là các bean được quản lý bởi SpỉngBoot. ĐIều này có nghĩa là Spring Boot sẽ tạo và quản lý các instance của các instance của các class được đánh dáu @Component.
- `@Autowired`: sử dụng để tiêm các dependency vò các thành phần khác nhau. khi đánh dấu một thuộc tính tằng @Autowired, Spring Boot sẽ tự động tiêm một instance của dependency tương ứng vào thuộc tính đó.

### 1.3. IoC (Inversion of Control)
- Nguyên tắc lập trình IoC, luồng điều khiển trong ứng dụng không được quyết định bởi ứng dụng mà quết định bởi framework hoặc container bên ngoài. 
- IoC thường đi kèm với DI, nên các dependency được quản lý và cung cấp bởi 1 framework hoặc container. Framework sẽ quản lý việc tạo và quản lý các đối tượng và phụ thuộc.