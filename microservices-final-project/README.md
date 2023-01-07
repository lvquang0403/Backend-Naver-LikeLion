# Thực hiện chức năng đơn giản với đề tài Dịch vụ chuyển đổi tiền tệ

### Họ và tên: Lê Vinh Quang

### Câu 1. Tạo một `Config Server` sử dụng git remote, gồm 3 file:

- link: https://github.com/lvquang0403/spring-cloud-config-server-repo
### Cập nhật properties khi ứng dụng đang chạy
- `POST` http://localhost:8765/actuator/refresh

### Câu 2 Tạo **Eureka** để làm máy chủ quản lý các service, Port là **8761**

- `GET`: http://localhost:8761/

### Câu 3. Tạo `Currency Exchange Server` dùng để lấy tỉ giá tiền tệ, Port **8000**

- Thêm dữ liệu:
  |id | currency_from | currency_to | conversion_multiple | port|
  |----|---------------|-------------|---------------------|------
  |1 | USD | VND | 23300 | 0|
  |2 | EUR | VND | 23800 | 0|
- `GET`: http://localhost:8765/api/currencyExchange/USD
- Kết quả:

```json
23300
```

- Tạo một instance với port là **8001**, đăng ký cả 2 instance với **Eureka Server**
![image](https://user-images.githubusercontent.com/108172013/191313064-60359cb4-5166-41d7-b02b-fbee09d8b94b.png)


### Câu 4. Tạo `Currency Calculation Service` thực hiện tính toán, Port là **8100**

- `GET`: http://localhost:8765/api/calculated/from/USD/to/VND/amount/10
| from | to  | amount |
  | ---- | --- | ------ |
  | USD  | VND | 10     |
- Kết quả:

```json
{
  "conversionMultiple": 23300,
  "quantity": 10,
  "totalCalculatedAmount": 233000,
  "port": "8100"
}
```
- Tạo một instance với port là **8101**, đăng ký cả 2 với **Eureka Server**
- ![image](https://user-images.githubusercontent.com/108172013/191316492-9027226c-1a16-4fac-a701-0c78a1eb93da.png)

### Câu 5. Tạo `Gateway` với port là **8765**, đăng ký tới **Eureka**
- Cài đặt Currency Exchange Service vào gateway
![image](https://user-images.githubusercontent.com/108172013/191313570-0cde6cb9-ac70-4e5b-9cd2-6fc86cccabbe.png)
