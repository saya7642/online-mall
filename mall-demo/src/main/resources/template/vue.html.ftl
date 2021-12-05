<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>{modelName}管理</title>
    <link rel="stylesheet" href="css/element.css">
    <link rel="stylesheet" href="css/base.css">
</head>
<body>
<div id="wrapper" v-cloak>
    <el-container>
        <my-aside :is-collapse="isCollapse"
                  :user="user">
        </my-aside>
        <el-container style="flex-direction: column">
            <my-header @change-coll="isCollapse = !isCollapse"
                       :is-collapse="isCollapse"
                       :user="user"
                       :logout="logout"
                       :clear-cache="clearCache">
            </my-header>
            <!-- 主体区域 -->
            <el-main>
                <div style="color: black; font-size: 20px; margin: 10px 0">{modelName}管理</div>
                <div style="height: 1px; background-color: white"></div>
                <el-input v-model="search" style="width: 20%;"
                          suffix-icon="el-icon-search"
                          placeholder="请输入名称按回车搜索"
                          @keyup.enter.native="loadTable">
                </el-input>
                <el-button @click="add" type="primary" size="mini" style="margin: 10px 0">新增</el-button>
                <!-- <el-button @click="exp" type="primary" size="mini" style="margin: 10px 0">导出</el-button> -->
                <el-table
                        :data="tableData"
                        border
                        style="width: 100%">
                    <template v-for="item in props">
                        <el-table-column
                                :prop="item.prop"
                                :label="item.label"
                                :show-overflow-tooltip="item.overflow || false"
                                width="200">
                        </el-table-column>
                    </template>
                    <el-table-column
                            fixed="right"
                            label="操作"
                            width="170">
                        <template slot-scope="scope">
                            <el-button @click="edit(scope.row)" type="primary">编辑</el-button>
                            <el-popconfirm
                                    @onConfirm="del(scope.row.{id})"
                                    title="确定删除？">
                                <el-button type="danger" slot="reference">删除</el-button>
                            </el-popconfirm>
                        </template>
                    </el-table-column>
                </el-table>
                <!-- 分页 -->
                <div style="background-color: white">
                    <el-pagination
                            @size-change="handleSizeChange"
                            @current-change="handleCurrentChange"
                            :current-page="pageNum"
                            :page-sizes="[5, 10, 20, 40]"
                            :page-size="pageSize"
                            layout="total, sizes, prev, pager, next, jumper"
                            :total="total">
                    </el-pagination>
                </div>

                <el-dialog title="{modelName}信息" :visible.sync="dialogFormVisible" width="30%"
                           close-on-click-modal="false" close-on-press-escape="false" show-close="false">
                    <el-form :model="entity">
                        <el-form-item
                                v-show="entity[props[0].prop] || !item.disabled"
                                :label="item.label"
                                label-width="100px"
                                v-for="item in props">
                            <el-input
                                    v-model="entity[item.prop]"
                                    :disabled="item.disabled"
                                    autocomplete="off"
                                    autocomplete="off" style="width: 80%">
                            </el-input>
                        </el-form-item>
                    </el-form>
                    <div slot="footer" class="dialog-footer">
                        <el-button @click="dialogFormVisible = false">取 消</el-button>
                        <el-button type="primary" @click="save">确 定</el-button>
                    </div>
                </el-dialog>

            </el-main>
        </el-container>
    </el-container>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/vue.min.js"></script>
<script src="js/element.js"></script>
<script src="js/tinymce/tinymce.min.js"></script>
<script src="js/base.js"></script>
<script src="js/axios.js"></script>
<script src="js/utils.js"></script>
<script src="js/app.js"></script>
<script src="pages/aside.js"></script>
<script src="pages/header.js"></script>


<script>
    const app = new Vue({
        el: '#wrapper',
        mixins: [common],
        data() {
            return {
                props: [
                    {props}
                ],
            };
        }
    });
</script>

</body>
</html>
