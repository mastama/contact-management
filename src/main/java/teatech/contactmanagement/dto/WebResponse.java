package teatech.contactmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebResponse <T>{

    /**
     * Menggunakan generic class
     * karena "data" yang digunakan berubah-ubah (bisa object, bisa string, bisa list, dll)
     */
    private T data;
    private String errors;
}
