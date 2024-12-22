import React from 'react'
import { Button, Card } from 'flowbite-react'
import videoIcon from '../assets/file-upload.png'

function VideoUpload() {
    return (
        <div className='w-1/2 mt-11'>
            <Card className='flex flex-col items-center justify-center dark:border-3, border-sky-200'>
                <div>
                    <form class="flex items-center justify-center space-x-6">
                        <div class="shrink-0">
                            <img class="h-20 w-20 object-cover rounded-full" src={videoIcon} alt="Video upload icon" />
                        </div>
                        <label className="block">
                            <span className="sr-only">Choose File</span>
                            <input type="file" class="block w-full text-sm text-slate-100
      file:mr-4 file:py-2 file:px-4
      file:rounded-full file:border-2
    "/>
                        </label>
                    </form>
                </div>

                <div className='flex justify-center'>
                    <Button className='px-5'>Upload</Button>
                </div>

            </Card>

        </div>
    )
}

export default VideoUpload