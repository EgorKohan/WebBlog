<#import "parts/common.ftl" as c>

<@c.page>
    <h2>List of articles</h2>
    <div>
        <table border="1px">
            <tr>
                <td>Title</td>
                <td>Text</td>
                <td>Tag</td>
                <td>Status</td>
                <td>Created at</td>
                <td>Updated at</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
            <#list articles as article>
                <tr>
                    <td><b>${article.title}</b></td>
                    <td><b>${article.text}</b></td>
                    <td><b>${article.tag}</b></td>
                    <td><b>${article.status}</b></td>
                    <td><b>${article.createdAt?datetime}</b></td>
                    <td><b>${article.updateAt?datetime}</b></td>
                    <td><a href="">Edit</a></td>
                    <td>
                        <form action="/articles/delete/{article.id}" name="delete" method="get">
                            <a href="/articles/delete/${article.id}">Delete</a>
                        </form>
                    </td>
                </tr>
            <#else>
                <p>List of articles is empty</p>
            </#list>
        </table>
    </div>
    <div>
        <h2>Add article</h2>
        <form method="post" name="/articles" action="/articles">
            <input type="text" name="title" placeholder="Title"/>
            <input type="text" name="text" placeholder="Text"/>
            <input type="text" name="tag" placeholder="Tag">
            <input type="submit"/>
        </form>
    </div>
    <div>
        <h2>Find article</h2>
        <form method="get" name="filter" action="/articles">
            <input type="text" name="filter" placeholder="Input tag" value="${filter!}">
            <input type="submit">
        </form>
    </div>
</@c.page>
