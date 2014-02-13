<h1>Add new category</h1>

<form id="saveCategory" action="admin_includes/save_category.jsp" method="post" enctype="multipart/form-data">
    <div class="form-back" id="form_back">
        <table>
            <tr>
                <td class="left-col"><label for="categoryName">Category Name</label></td>
                <td><input type="text" class="textinput" id="categoryName" name="categoryName"/></td>
            </tr>
            <tr>
                <td><label for="categoryDescription">Category Description</label></td>
                <td><textarea id="categoryDescription" name="categoryDescription"></textarea></td>
            </tr>
            <tr>
                <td>Image</td>
                <td><input type="file" name="imageFile"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save" class="button"/><input type="button" class="button"
                                                                             value="Cancel"/>
                </td>
            </tr>
        </table>
    </div>
</form>