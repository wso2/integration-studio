$(document)
		.ready(
				function() {
					var i = 0;
					var text = '{"artifactid": "file","projectname": "File","artifacts": [{"artifactid": "file1","projectname": "File1","serverrole": "File"},{"artifactid": "file2","projectname": "File2","serverrole": "File"},{"artifactid": "file3","projectname": "File3","serverrole": "File"}]}';
					var obj = JSON.parse(text);
					var a;
					for (a = 0; a < obj.artifacts.length; a++) {
						$('#item' + i)
								.html(
										"<td><label><input type=\"checkbox\"></label></td><td>"
												+ obj.artifacts[a].projectname
												+ "</td><td>"
												+ obj.artifacts[a].artifactid
												+ "</td><td >"
												+ obj.artifacts[a].serverrole
												+ "</td>");
						alert("current value of a : " + a);
						$('#tab_logic').append(
								'<tr id="item' + (i + 1) + '"></tr>');
						i++;
					}

				});
