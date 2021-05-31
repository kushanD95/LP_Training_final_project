import { Controller, Get, Post, Body, Patch, Param, Delete, HttpException, HttpStatus, HttpCode, UseGuards } from '@nestjs/common';
import { TaskService } from './task.service';
import { CreateTaskDto } from './dto/create-task.dto';
import { UpdateTaskDto } from './dto/update-task.dto';
import { Task } from 'src/models/task.model';;
import { Oauth2AuthGuard } from '../auth/oauth2-auth.guard';

@Controller('task')
export class TaskController {
  constructor(private readonly taskService: TaskService) { }

  @Post()
  async create(@Body() createTaskDto: CreateTaskDto): Promise<Task> {
    try {
      return await this.taskService.create(createTaskDto);
    } catch (error) {
      console.log(error);
      throw new HttpException('Invalid task details!', HttpStatus.SERVICE_UNAVAILABLE);
    }
  }

  @Get()
  async findAll(): Promise<Task[]> {
    try {
      return await this.taskService.findAll();
    } catch (error) {
      console.log(error);
      throw new HttpException('Task not found!', HttpStatus.NOT_FOUND);
    }
  }

  @Get(':id')
  async findOne(@Param('id') id: number) {
    try {
      return await this.taskService.findOne(id);
    } catch (error) {
      console.log(error);
      throw new HttpException('Task not found!', HttpStatus.NOT_FOUND);
    }
  }

  @Get('driver/:id')
  async findTaskFromDriver(@Param('id') id: number) {
    try {
      return await this.taskService.findTaskFromDriver(id);
    } catch (error) {
      console.log(error);
      throw new HttpException('Task not found!', HttpStatus.NOT_FOUND);
    }
  }

  @Get('operator/:id')
  async findTaskFromOperator(@Param('id') id: number) {
    try {
      return await this.taskService.findTaskFromOperator(id);
    } catch (error) {
      console.log(error);
      throw new HttpException('Task not found!', HttpStatus.NOT_FOUND);
    }
  }

  @Patch(':id')
  async update(@Param('id') id: number, @Body() updateTaskDto: UpdateTaskDto): Promise<Task> {
    return await this.taskService.update(id, updateTaskDto);
  }

  @HttpCode(204)
  @Delete(':id')
  async remove(@Param('id') id: number) {
    return await this.taskService.remove(id);
  }
}
