package apiTests.tests;

import apiTests.model.AuthorizationResponse;
import apiTests.model.EntityManagerClass;
import apiTests.data.EmployeeAndCompanyData;
import apiTests.entity.CompanyEntity;
import apiTests.entity.EmployeeEntity;
import apiTests.helper.AuthHelper;
import apiTests.helper.DBHelper;
import apiTests.helper.RequestHelper;
import io.restassured.http.ContentType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import apiTests.model.CreateEmployeeRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import static apiTests.helper.DBHelper.*;
import static apiTests.helper.RequestHelper.createEmployeeRequest;
import static apiTests.helper.RequestHelper.mandatoryFields;
import static apiTests.helper.ResponseHelper.TOKEN_TYPE;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class PositiveBusinessTests {

    private static EntityManager entityManager;
    AuthorizationResponse info = RequestHelper.auth();


    @BeforeAll
    public static void setUp() throws IOException {

        PositiveBusinessTests.entityManager = EntityManagerClass.setUp();
        AuthHelper.restAssuredSetUp();

    }

    @Test
    @DisplayName("Успешное удаление только что созданного сотрудника")
    public void iCanDeleteCreatedEmployee() throws IOException {

        int id = createEmployeeInDB();

        deleteEmployeeFromDB(id);
        CompanyEntity shouldBeNull = entityManager.find(CompanyEntity.class, id);
        assertNull(shouldBeNull);

    }

    @Test
    @DisplayName("Получение пустого списка сотрудников у только что созданной компании")
    public void iCanGetEmptyListOfEmployeesDB() throws IOException {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery("SELECT ce FROM EmployeeEntity ce WHERE ce.companyId = :desiredCompanyId", EmployeeEntity.class);
        query.setParameter("desiredCompanyId", createNewCompanyInDB());

        List<EmployeeEntity> employee = query.getResultList();

        assertEquals(0, employee.size());

    }

    //Bug не сохраняется изменения значений в поля url, email и isActive
    @Test
    @DisplayName("Изменение информации о сотруднике")
    public void changeEmployeeData() throws IOException {

        int newEmployeeId = createEmployeeInDB();
        given()
                .basePath("employee")
                .body(createEmployeeRequest(new CreateEmployeeRequest(), mandatoryFields))
                .header(TOKEN_TYPE, info.userToken())
                .contentType(ContentType.JSON)
                .when()
                .patch("{id}", newEmployeeId)
                .then()
                .body("url", equalTo(EmployeeAndCompanyData.CHANGED_AVATAR_URL))
                .body("email", equalTo(EmployeeAndCompanyData.CHANGED_EMAIL))
                .body("isActive", equalTo(false));


        EmployeeEntity employeeFromDB = DBHelper.getEmployeeById(newEmployeeId);

        assert employeeFromDB != null;
        String toStringBirthday = new SimpleDateFormat("yyyy-MM-dd").format(employeeFromDB.getDate());

        assertEquals(EmployeeAndCompanyData.FIRST_NAME, employeeFromDB.getFirstName());
        assertEquals(EmployeeAndCompanyData.CHANGED_LAST_NAME, employeeFromDB.getLastName());
        assertTrue(employeeFromDB.isActive());
        assertEquals(EmployeeAndCompanyData.MIDDLE_NAME, employeeFromDB.getMiddleName());
        assertEquals(EmployeeAndCompanyData.CHANGED_BIRTHDAY, toStringBirthday);
        assertEquals(EmployeeAndCompanyData.CHANGED_AVATAR_URL, employeeFromDB.getAvatarUrl());
        assertEquals(EmployeeAndCompanyData.CHANGED_EMAIL, employeeFromDB.getEmail());
        assertEquals(EmployeeAndCompanyData.CHANGED_PHONE, employeeFromDB.getPhone());

    }


}
