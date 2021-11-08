package org.iesfm.instituto.jdbc;

import org.iesfm.instituto.jdbc.classes.Title;
import org.iesfm.instituto.jdbc.configuration.InstitutoConfiguration;
import org.iesfm.instituto.jdbc.dao.TitleDAO;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InstitutoConfiguration.class)
public class TitleDAOTests {

    @Autowired
    private TitleDAO titleDAO;

    @Test
    @Ignore
    public void insert() {
        Title title = new Title(
                null,
                "Administración y finanzas",
                "GS",
                "Admin",
                "Cosas administrativas"
        );
        titleDAO.insert(title);

        Assert.assertNotNull(titleDAO.get("Finanzas"));
    }

    @Test
    public void get() {
        Assert.assertNotNull(titleDAO.get("DAM"));
        Assert.assertNull(titleDAO.get("DAM2"));
    }

    @Test
    public void listInformatica() {
        List<Title> titles = titleDAO.list("Informática");
        Assert.assertEquals(2, titles.size());
    }
}
