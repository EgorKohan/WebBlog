<#import "parts/common.ftl" as c>
<@c.page>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><a href="/user/${user.id}">Edit</a></td>
            </tr>
        </#list>
    </table>
</@c.page>