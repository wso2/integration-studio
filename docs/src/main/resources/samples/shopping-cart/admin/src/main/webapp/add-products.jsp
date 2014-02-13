<ul class="breadcrumb">
    <li><a>Home ></a></li>
    <li><a>Products ></a></li>
    <li><a class="last">Digital Cameras</a></li>
</ul>
<div style="clear:both;"></div>
<div class="content">
    <div class="page-headding"><h1>Add new item</h1></div>
    <form action="item_save.jsp" method="get">
        <table cellpadding="0" cellspacing="0" border="0" class="formTable">
            <tr>
                <td class="first">Product Id</td>
                <td><input type="text" name="pId"/></td>
            </tr>
            <tr>
                <td>category</td>
                <td>
                    <select>
                        <option>Cameras & Photo</option>
                        <!-- <option>Antiques</option>
                   <option>Art</option> 
                    <option>Baby</option>
                    <option>Books</option>
                    <option>Business & Industrial</option>
                    <option>Cameras & Photo</option>
                    <option>Cars, Boats, Vehicles & Parts</option>
                    <option>Cell Phones & PDAs</option>
                    <option>Clothing, Shoes & Accessories</option>
                    <option>Coins & Paper Money</option>
                    <option>Collectibles</option> 
                    <option>Computers & Networking</option>  -->
                    </select>

                </td>
            </tr>
            <tr>
                <td>Description</td>
                <td><textarea class="pro-description" name="des"></textarea></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="save"/></td>
            </tr>
        </table>
    </form>
</div>