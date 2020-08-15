<%@ include file="header.jsp"%>
<table class="table">
    <thead class="thead-light">
    <tr>
<th style="text-align: center"><a href="${item.id}/edit">EDIT</a></th>
<th style="text-align: center"><a href="${item.id}/delete">DELETE</a></th>
    </tr>
    </thead>
</table>
<div style="width:20%" class="card">
    <img src="${context}/images/pict.jpg" alt="" style="width:100%">
    <h1>${item.name}</h1>
    <p class="price">${item.price}</p>
    <p>${item.description}</p>
    <p><button>Добавить карточку</button></p>
</div>
</body>
</html>
