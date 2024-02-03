package com.example.worldinfo.worldinfoservice.models.responses.menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientMenuTest {

    @Test
    void createDefault() {
        ClientMenu clientMenu = ClientMenu.createDefault();
        assertNotNull(clientMenu);
        assertEquals(3, clientMenu.getMenuItems().size());
    }
}