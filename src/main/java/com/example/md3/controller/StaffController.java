package com.example.md3.controller;

import com.example.md3.model.Department;
import com.example.md3.model.Staff;
import com.example.md3.service.StaffService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StaffController", value = "/staffs")
public class StaffController extends HttpServlet {
    private StaffService staffService = new StaffService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "findAll":
                showAll(req, resp);
                break;
            case "create":
                showAddForm(req, resp);
                break;
            case "edit":
                showEditPage(req,resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "searchName":
                showSearchByName(req, resp);
                break;
        }
    }

    public void showAll(HttpServletRequest rep, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = rep.getRequestDispatcher("staffs/home.jsp");
        List<Staff> staffs = staffService.findAll();
        rep.setAttribute("staffs", staffs);
        dispatcher.forward(rep, resp);
    }

    public void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("staffs/create.jsp");
        dispatcher.forward(request, response);
    }

    public void showEditPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idEdit = Integer.parseInt(req.getParameter("idEdit"));
        req.setAttribute("idEdit", idEdit);
        Staff staffEdit = staffService.findById(idEdit);
        req.setAttribute("staffEdit", staffEdit);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Staffs/edit.jsp");
        dispatcher.forward(req, resp);

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.staffService.delete(id);
        response.sendRedirect("/staffs?action=findAll");
    }

    private void showSearchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputName = req.getParameter("inputName");
        List<Staff> searchStaffList = staffService.searchByName(inputName);
        System.out.println(searchStaffList.size());
        req.setAttribute("staffs", searchStaffList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Staffs/searchName.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                addStaff(req, resp);
                break;
            case "edit":
                editStaff(req,resp);
                break;

        }
    }

    public void addStaff(HttpServletRequest rep, HttpServletResponse resp) throws IOException {
        String name = rep.getParameter("name");
        String email = rep.getParameter("email");
        String address = rep.getParameter("address");
        String phone = rep.getParameter("phone");
        double salary = Double.parseDouble(rep.getParameter("salary"));
        int idDepartment = Integer.parseInt(rep.getParameter("idDepartment"));
        Department department = new Department(idDepartment);
        Staff newStaff = new Staff( name, email, address, phone, salary, department);
        staffService.add(newStaff);
        resp.sendRedirect("/staffs?action=findAll");
    }

    public void editStaff(HttpServletRequest rep, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(rep.getParameter("id"));
        String name = rep.getParameter("name");
        String email = rep.getParameter("email");
        String address = rep.getParameter("address");
        String phone = rep.getParameter("phone");
        double salary = Double.parseDouble(rep.getParameter("salary"));
        int idDepartment = Integer.parseInt(rep.getParameter("idDepartment"));
        Department department = new Department(idDepartment);
        Staff staff = new Staff( name, email, address, phone, salary, department);
        staffService.edit(id, staff);
        resp.sendRedirect("/staffs?action=findAll");
    }

}
