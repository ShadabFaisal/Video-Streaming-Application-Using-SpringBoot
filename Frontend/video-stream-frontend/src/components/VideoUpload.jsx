import React, { useState } from 'react'
import { Button, Card, TextInput, Label, Textarea } from 'flowbite-react'
import videoIcon from '../assets/file-upload.png'
import axios from 'axios';

function VideoUpload() {

    const [selectedFile, setSelectedFile] = useState(null);
    const [metadata, setMetadata] = useState({
        title: "",
        description: "",
    })
    const [progress, setProgress] = useState(0);
    const [uploading, setUploading] = useState(false);
    const [message, setMessage] = useState();

    function handleFileChange(event) {
        //console.log(event.target.files[0]);
        setSelectedFile(event.target.files[0]);

    }
    function formFieldChange(event){
        setMetadata({
            ...metadata,
            [event.target.name]:event.target.value
        })   
    }
    function handleForm(formEvent) {
        formEvent.preventDefault();
        // console.log(metadata);

        if(!selectedFile){
            alert("Select File!!!");
            return;
        }
        //Upload the video to server
        saveVideoToServer(selectedFile, metadata);
        
    }

    async function saveVideoToServer(video, videoMetadata){
        setUploading(true);

        // API call
        try {
            let formData=new FormData();
            formData.append("title", metadata.title);
            formData.append("description", metadata.description);
            formData.append("file", selectedFile);
           let response= await axios.post('http://localhost:8080/api/v1/videos', formData, {
                headers:{
                    'Content-Type':'multipart/form-data',
                },
                onUploadProgress: (progressEvent)=>{
                    console.log(progressEvent);
                }
            }); 
            console.log(response);
            
            setMessage("File Uploaded Successfully!")
        } catch (error) {
            console.log(error);
            
        }
        
    }



    return (
        <div className='w-1/2 mt-11'>
            <Card className='flex flex-col items-center justify-center dark:border-3 border-sky-200'>
                <div>
                    <form noValidate onSubmit={handleForm} className='flex flex-col space-y-5'>
                        <div className='space-y-3'>
                            <div>
                                <Label value="Video Title" />
                            </div>
                            <TextInput onChange={formFieldChange} name='title' placeholder='Enter title' />
                        </div>
                        <div className='space-y-3'>
                            <div>
                                <Label value="Video Description" />
                            </div>
                            <Textarea onChange={formFieldChange} name='description' placeholder='Enter Description' />
                        </div>

                        <div className='flex items-center justify-center space-x-6'>
                            <div className="shrink-0">
                                <img className="h-20 w-20 object-cover rounded-full" src={videoIcon} alt="Video upload icon" />
                            </div>
                            <label className="block">
                                <span className="sr-only">Choose File</span>
                                <input
                                name='file'
                                    onChange={handleFileChange}
                                    type="file" className="block w-full text-sm text-slate-100
      file:mr-4 file:py-2 file:px-4
      file:rounded-full file:border-2
    "/>
                            </label>
                        </div>
                        <div className='flex justify-center'>
                            <Button type='submit' className='px-5'>Upload</Button>
                        </div>
                    </form>
                </div>
            </Card>
        </div>
    )
}

export default VideoUpload