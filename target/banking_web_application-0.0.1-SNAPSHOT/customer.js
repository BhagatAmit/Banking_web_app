b1.onclick = () => {
    let url = "http://localhost:9000/student_restful_api_demo/students";
    fetch(url)
        .then(response => response.json())
        .then(res => {
            let data = "<table class='table table-striped table-bordered'> <thead class='thead-dark'> <tr><th>ID</th><th>Name</th><th>Age</th><th>City</th><th>Gender</th></thead><tbody>"
            res.forEach(e => {
                data = data + "<tr><td>" + e.id + "</td>";
                data = data + "<td>" + e.name + "</td>";
                data = data + "<td>" + e.age + "</td>";
                data = data + "<td>" + e.city + "</td>";
                data = data + "<td>" + e.gender + "</td></tr>";
            });
            data = data + "</tbody></table>"
            document.getElementById("results").innerHTML = data;
        })

}
b2.onclick = () => {
    let url = "http://localhost:9000/student_restful_api_demo/student?id=" + document.getElementById("value").value;
    fetch(url)
        .then(response => response.json())
        .then(e => {
            let data = "<table class='table table-striped table-bordered'> <thead class='thead-dark'> <tr><th>ID</th><th>Name</th><th>Age</th><th>City</th><th>Gender</th></thead><tbody>"
            //res.forEach(e => {
            data = data + "<tr><td>" + e.id + "</td>";
            data = data + "<td>" + e.name + "</td>";
            data = data + "<td>" + e.age + "</td>";
            data = data + "<td>" + e.city + "</td>";
            data = data + "<td>" + e.gender + "</td></tr>";
            // });
            data = data + "</tbody></table>"
            document.getElementById("results").innerHTML = data;
        })

}