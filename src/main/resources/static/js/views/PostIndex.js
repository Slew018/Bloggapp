export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
            
       <form>
            <div class="form-group">
       <label for="postid">post id</label>
       <input type="text" class="formcontrol" id="postid" placeholder="Enter ID">
            </div>
            <div class="form-group">
       <label for="post-title">title</label>
       <input type="text" class="formcontrol" id="post-title" placeholder="Enter Title">
            </div>    
            <div class="form-group">
       <label for="post-content">content</label>
       <textarea type="text" class="formcontrol" id="post-content" placeholder="Enter Content" rows="3"></textarea>
            </div>        
        <button type="submit" class="btn" btn="primary" id="submit">Submit</button>
        </form>
            <div>
                ${props.posts.map(post => `<h3 class="post-title">${post.title}</h3>
                <button type="button"  class="post-edit-btn" data-id="${post.id}">Edit</button>
                <button type="button" class="post-delete-btn data-id="${post.id}">Delete</button>"
                <p>posted by: ${post.user.username}</p>
                        <h2 class="post-content">${post.content}</h2>`).join('')}
            </div>
        </main>
    `;
}


export function postEvents() {
    createPostEvent()
    editPostEvent()
    deletePostEvent()
    submitEditEvent()
}

function createPostEvent() {
    $("Submit").click(function () {
        let post = {
            title: $("post-title").val(),
            content: $("post-content").val()
        }

        let request = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(post)
        }

        fetch("http://localhost:8080/api/posts", request).then(createView("/posts"));
    })
}

function editPostEvent() {
    $('#post-edit-btn').click(function () {
        $(this).siblings(".post-title, .post-content").attr("contenteditable", true)
        $(this).text("submit")
        $(this).on("click", submitEditEvent)
    })

}
function submitEditEvent(){
    let posts = {
        title: $(this).siblings("post-title").text(),
        content: $(this).siblings("post-title").text()
    }
    console.log(posts);
    let request = {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(posts)
    }

    let id = $(this).attr("data-id")
    fetch(`http://localhost:8080/api/posts/${id}`, request).then(response => {
        console.log(response.status)
        createView("/posts")
    })
}

function deletePostEvent(){
    $('.post-delete-btn').click(function (){
        let request = {
            method: 'DELETE',
            header: {'Content-Type': 'application/json'},
        }
        let id = $(this).attr("data-id")
        fetch(`http://localhost:8080/api/posts/${id}`, request).then(response => {
            console.log(response.status)
            createView("/posts")
        })
    })
}