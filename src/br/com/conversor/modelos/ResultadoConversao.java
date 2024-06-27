package br.com.conversor.modelos;

import com.google.gson.annotations.SerializedName;

public record ResultadoConversao(
        @SerializedName("conversion_result") double conversionResult
) {

}
