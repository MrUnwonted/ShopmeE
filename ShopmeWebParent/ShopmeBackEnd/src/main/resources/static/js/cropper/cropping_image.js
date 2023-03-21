function cropImage(imageBox,cropBtn,idImage,confirmBtn ,thumbnail, img, aspectRatio) {
    // image-box is the id of the div element that will store our cropping image preview
    const imagebox = document.getElementById(imageBox)
// crop-btn is the id of button that will trigger the event of change original file with cropped file.
    const crop_btn = document.getElementById(cropBtn)
// id_image is the id of the input tag where we will upload the image
    const input = document.getElementById(idImage)

// When user uploads the image this event will get triggered
//     input.addEventListener('change', () => {
        // Getting image file object from the input variable
        const img_data = input.files[0]
        // createObjectURL() static method creates a DOMString containing a URL representing the object given in the parameter.
        // The new object URL represents the specified File object or Blob object.
        const url = URL.createObjectURL(img_data)

        // Creating a image tag inside imagebox which will hold the cropping view image(uploaded file) to it using the url created before.
        imagebox.innerHTML = `<img src="${url}" id="${img}" style="width:100%;">`

        // Storing that cropping view image in a variable
        const image = document.getElementById(img)

        // Displaying the image box
        document.getElementById(imageBox).style.display = 'block'
        // Displaying the Crop buttton
        document.getElementById(cropBtn).style.display = 'block'
        // Hiding the Post button
        document.getElementById(confirmBtn).style.display = 'none'

        // Creating a croper object with the cropping view image
        // The new Cropper() method will do all the magic and diplay the cropping view and adding cropping functionality on the website
        // For more settings, check out their official documentation at https://github.com/fengyuanchen/cropperjs
        const cropper = new Cropper(image, {
            autoCropArea: 1,
            viewMode: 1,
            scalable: false,
            zoomable: false,
            movable: false,
            aspectRatio: aspectRatio
        })

        // When crop button is clicked this event will get triggered
        crop_btn.addEventListener('click', () => {
            // This method coverts the selected cropped image on the cropper canvas into a blob object
            cropper.getCroppedCanvas().toBlob((blob) => {

                // Gets the original image data
                let fileInputElement = document.getElementById(idImage);

                // Make a new cropped image file using that blob object, image_data.name will make the new file name same as original image
                let file = new File([blob], img_data.name, {type: "image/*", lastModified: new Date().getTime()});
                // Create a new container
                let container = new DataTransfer();
                // Add the cropped image file to the container
                container.items.add(file);

                // Replace the original image file with the new cropped image file
                fileInputElement.files = container.files;
                showImageThumbnail(fileInputElement, thumbnail);

                // Hide the cropper box
                document.getElementById(imageBox).style.display = 'none'
                // Hide the crop button
                document.getElementById(cropBtn).style.display = 'none'
                // Display the Post button
                document.getElementById(confirmBtn).style.display = 'block'


            });
        });
    // });
}


function showImageThumbnail(fileInput, thumbnail) {
    var file = fileInput.files[0];
    var reader = new FileReader();
    reader.onload = function (e) {
        $("#"+ thumbnail).attr("src", e.target.result);
    };


    reader.readAsDataURL(file);
}

function checkFileSize(fileInput) {
    fileSize = fileInput.files[0].size;

    if (fileSize > MAX_FILE_SZIE) {
        fileInput.setCustomValidity("You must choose an image less that 5MB!");
        fileInput.reportValidity();

        return false;

    } else {
        fileInput.setCustomValidity("");
        return true;
    }
}
