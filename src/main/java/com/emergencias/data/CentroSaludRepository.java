package com.emergencias.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

public class CentroSaludRepository {
    private final ObjectMapper mapper = new ObjectMapper();
    private List<CentroSalud> centros = new ArrayList<>();

    public void cargarDesdeFichero() {
        try (InputStream is = getClass().getClassLoader()
                .getResourceAsStream("data/centros_salud.json")) {

            if (is == null) throw new IllegalStateException("No se encontró data/centros_salud.json en resources");
            centros = mapper.readValue(is, new TypeReference<List<CentroSalud>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error leyendo centros_salud.json: " + e.getMessage(), e);
        }
    }

    public int size() {
        return centros.size();
    }

    public List<CentroSalud> getAll() {
        return centros;
    }

    public Optional<CentroSalud> getByCodigo(String codigo) {
        if (codigo == null) return Optional.empty();
        return centros.stream().filter(c -> codigo.equals(c.codigo)).findFirst();
    }

    public List<CentroSalud> searchByMunicipio(String municipio) {
        if (municipio == null) return new ArrayList<>();
        String q = municipio.trim().toLowerCase(Locale.ROOT);

        return centros.stream()
                .filter(c -> c.municipio != null && c.municipio.toLowerCase(Locale.ROOT).contains(q))
                .collect(Collectors.toList());
    }
}
