<script lang="ts">

</script>

<main>
    <form action="http://localhost:8080/api/supportrequests/add" method="POST">
        <label for="email-group">Your Email:</label>
        <input type="email" id="email-group" name="email" placeholder="name@trasik.com" required>
        <label for="description-group">Request Description:</label>
        <textarea id="description-group" name="description" rows="4" cols="50" placeholder="Please enter the description of your request..." minlength="100" maxlength="1000" required>

        </textarea>
        <label for="date-group">Request Due Date:</label>
        <input type="date" id="date-group" name="dueDate" required>
        <button type="submit">Submit</button>
    </form>
</main>