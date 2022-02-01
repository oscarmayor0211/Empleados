package com.empleado.registroEmpleado.services;
import com.empleado.registroEmpleado.models.Persona;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
@SpringBootTest
class PersonaServiceImplTest {
    private final String URL = "/api/persona";
    @Autowired
    MockMvc mvc;
    @Test
    void createPersona() throws Exception {
        Persona persona = new Persona();
        persona.setTipoId("CC");
        persona.setSegundoNombre("ANDRES");
        persona.setPrimerNombre("JUAN");
        persona.setSegundoApellido("MEJIA");
        persona.setEstado("ACTIVO");
        persona.setPaisEmpleo("COLOMBIA");
        persona.setPrimerApellido("MAYOR");
        persona.setArea("DESARROLLO");
        persona.setCedula("67577867");

        mvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(persona))).andExpect(status().isOk()).andDo(print());
    }

    @Test
    void updatePersona()  throws Exception{
        Persona persona = new Persona();
        persona.setTipoId("CC");
        persona.setSegundoNombre("CARLOS");
        persona.setPrimerNombre("JUAN");
        persona.setSegundoApellido("MEJIA");
        persona.setEstado("ACTIVO");
        persona.setPaisEmpleo("COLOMBIA");
        persona.setPrimerApellido("MAYOR");
        persona.setArea("DESARROLLO");
        persona.setCedula("67577867");
        mvc.perform(put(URL+ "/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(persona))).andExpect(status().isOk()).andDo(print());
    }

    @Test
    void getAllPersona()throws Exception {
        mvc.perform(get(URL)).andDo(print());
    }
    @Test
    public void cedulaExiste() throws Exception {

        Persona persona = new Persona();
        persona.setTipoId("CC");
        persona.setSegundoNombre("CARLOS");
        persona.setPrimerNombre("JUAN");
        persona.setSegundoApellido("MEJIA");
        persona.setEstado("ACTIVO");
        persona.setPaisEmpleo("COLOMBIA");
        persona.setPrimerApellido("MAYOR");
        persona.setArea("DESARROLLO");
        persona.setCedula("67577867");
        mvc.perform(post(URL).content(toJson(persona)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("!CIDENET¡-Error ya existe la persona  con cedula: " + persona.getCedula()))
                .andDo(print());
    }

    @Test
    void deletePersona()   throws Exception {
        mvc.perform(delete(URL+"/1")).andDo(print());
    }

    @Test
    void existsByCedula() throws Exception {
        mvc.perform(get(URL+"/67577867")).andDo(print());
    }
    public static String toJson(final Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}