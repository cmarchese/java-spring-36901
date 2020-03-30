<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-striped">
    <thead class="thead-dark">
    <tr>
        <th>TODO</th>
        <th>Blocked</th>
        <th>In Progress</th>
        <th>Done</th>
    </tr>
    </thead>

    <tbody>
    <tr>
        <td>
            <c:forEach var="task" items="${tasks}">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">${task.title}</h5>
                        <p class="card-text">${task.description}</p>
                        <p class="card-text">${task.dueDate}</p>
                    </div>
                </div>
            </c:forEach>
        </td>

        <td>
            <c:forEach var="task" items="${tasks}">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">${task.title}</h5>
                        <p class="card-text">${task.description}</p>
                        <p class="card-text">${task.dueDate}</p>
                    </div>
                </div>
            </c:forEach>
        </td>

        <td>
            <c:forEach var="task" items="${tasks}">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">${task.title}</h5>
                        <p class="card-text">${task.description}</p>
                        <p class="card-text">${task.dueDate}</p>
                    </div>
                </div>
            </c:forEach>
        </td>

        <td>
            <c:forEach var="task" items="${tasks}">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">${task.title}</h5>
                        <p class="card-text">${task.description}</p>
                        <p class="card-text">${task.dueDate}</p>
                    </div>
                </div>
            </c:forEach>
        </td>
    </tr>
    </tbody>
</table>