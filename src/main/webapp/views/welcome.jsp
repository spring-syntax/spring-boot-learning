<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    Welcome ${name}!
    <form value="/welcome">
        <input type="submit" value="Go to Login Page"/>
    </form>
    </br>
        <a href="/todo-list">Click here</a> to see to do list.
</div>
<%@ include file="common/footer.jspf" %>