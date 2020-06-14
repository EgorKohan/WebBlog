<#import "parts/common.ftl" as c>
<@c.page>
    User Editor
    <form action="/user" method="post">
        <input type="text" value="${user.username}" name="username">
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Save</button>
    </form>
</@c.page>