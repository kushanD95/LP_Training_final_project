import { Injectable, NotFoundException } from '@nestjs/common';
import { InjectModel } from '@nestjs/mongoose';
import { Document, Model } from 'mongoose';
import { Task } from 'src/models/task.model';
import { CreateTaskDto } from './dto/create-task.dto';
import { UpdateTaskDto } from './dto/update-task.dto';

interface TaskModel extends Task, Document { }

@Injectable()
export class TaskService {

  constructor(@InjectModel('Task') private readonly taskModel: Model<TaskModel>) {

  }

  task: CreateTaskDto[] = [];

  async create(createTaskDto: CreateTaskDto) {
    let newTask = new this.taskModel(createTaskDto);
    newTask = await newTask.save();
    return newTask;
  }

  async findAll() {
    const products = await this.taskModel.find().exec();
    return products;
  }

  async findOne(id: number) {
    let selectedProduct;
    try {
      selectedProduct = await this.taskModel.findById(id);
    } catch (error) {
      throw new NotFoundException('could not found Task!');
    }

    if (!selectedProduct) {
      throw new NotFoundException('could not found Task!');
    }
    return {
      id: selectedProduct.id,
      driver_id: selectedProduct.driver_id,
      operator_id: selectedProduct.operator_id,
      vehicle_id: selectedProduct.vehicle_id,
      location: selectedProduct.location,
      reason: selectedProduct.reason,
      is_done: selectedProduct.is_done,
      images: selectedProduct.images
    };
  }

  async update(id: number, updateTaskDto: UpdateTaskDto) {
    let selectedTask = await this.findOne(id);

    if (updateTaskDto.driver_id) {
      selectedTask.driver_id = updateTaskDto.driver_id;
    }
    if (updateTaskDto.operator_id) {
      selectedTask.operator_id = updateTaskDto.operator_id;
    }
    if (updateTaskDto.vehicle_id) {
      selectedTask.vehicle_id = updateTaskDto.vehicle_id;
    }
    if (updateTaskDto.location) {
      selectedTask.location = updateTaskDto.location;
    }
    if (updateTaskDto.reason) {
      selectedTask.reason = updateTaskDto.reason;
    }
    if (updateTaskDto.is_done) {
      selectedTask.is_done = updateTaskDto.is_done;
    }
    if (updateTaskDto.is_done) {
      selectedTask.images = updateTaskDto.images;
    }

    const createdModel = new this.taskModel(selectedTask);

    return await createdModel.save();
  }

  async remove(id: number) {
    const deletedtask = await this.taskModel.deleteOne({ _id: id }).exec();
    if (deletedtask.n === 0) {
      throw new NotFoundException("could not found user id - " + id);
    }
    return deletedtask;
  }


  async findTaskFromDriver(id: number) {
    const fetchedTasks: Task[] = await this.findAll();
    let selectedTasks: Task[] = [];

    if (fetchedTasks) {
      fetchedTasks.filter(task => {
        if (task.driver_id == id) {
          selectedTasks.push(task);
        }
      });
      if (fetchedTasks.length == 0) {
        throw new NotFoundException('Tasks are not created from drive id - ' + id);
      }
      return selectedTasks;
    } else {
      throw new NotFoundException('Tasks are not found');
    }
  }

  async findTaskFromOperator(id: number) {
    const fetchedTasks: Task[] = await this.findAll();
    let selectedTasks: Task[] = [];

    if (fetchedTasks) {
      fetchedTasks.filter(task => {
        if (task.operator_id == id) {
          selectedTasks.push(task);
        }
      });
      if (fetchedTasks.length == 0) {
        throw new NotFoundException('Tasks are not choose from operator id - ' + id);
      }
      return selectedTasks;
    } else {
      throw new NotFoundException('Tasks are not found');
    }
  }
}
